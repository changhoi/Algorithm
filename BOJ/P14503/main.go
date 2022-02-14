package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

const (
	north = iota
	east
	south
	west
)

func atoi(s string) int {
	ret, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}

	return ret
}

func getDirection(d int) [2]int {
	switch d {
	case north:
		return [2]int{-1, 0}
	case east:
		return [2]int{0, 1}
	case south:
		return [2]int{1, 0}
	case west:
		return [2]int{0, -1}
	default:
		panic("invalid direction")
	}
}

type Map struct {
	m             [][][2]bool
	y, x, cleaned int
}

func (m *Map) Clean(r, c int) {
	m.m[r][c][1] = true
	m.cleaned++
}

func (m *Map) IsCleared(r, c int) bool {
	return m.m[r][c][1]
}

func (m *Map) IsValidRC(r, c int) bool {
	return 0 <= r && r < m.y && 0 <= c && c < m.x
}

func (m *Map) IsWall(r, c int) bool {
	return m.m[r][c][0]
}

func (m *Map) IsCleanable(r, c int) bool {
	return m.IsValidRC(r, c) && !m.IsCleared(r, c) && !m.IsWall(r, c)
}

func (m *Map) HasUncleared(r, c int) bool {
	n := [2]int{r - 1, c}
	e := [2]int{r, c + 1}
	s := [2]int{r + 1, c}
	w := [2]int{r, c - 1}
	return m.IsCleanable(n[0], n[1]) || m.IsCleanable(e[0], e[1]) || m.IsCleanable(s[0], s[1]) || m.IsCleanable(w[0], w[1])
}

func NewMap(y, x int) *Map {
	m := make([][][2]bool, y)
	for i := 0; i < y; i++ {
		m[i] = make([][2]bool, x)
	}

	return &Map{
		m:       m,
		y:       y,
		x:       x,
		cleaned: 0,
	}
}

type Robot struct {
	r, c, direction int
}

func (r *Robot) GetLeftDirection() int {
	if r.direction == 0 {
		return 3
	} else {
		return r.direction - 1
	}
}

func (r *Robot) TurnLeft() {
	r.direction = r.GetLeftDirection()
}

func (r *Robot) GetLeftRC() (nr, nc int) {
	d := getDirection(r.GetLeftDirection())
	nr = r.r + d[0]
	nc = r.c + d[1]
	return
}

func (r *Robot) GetNextRC() (nr, nc int) {
	d := getDirection(r.direction)
	nr = r.r + d[0]
	nc = r.c + d[1]
	return
}

func (r *Robot) GetBackwardRC() (nr, nc int) {
	d := getDirection(r.direction)
	nr = r.r - d[0]
	nc = r.c - d[1]
	return
}

// Move direction is 1 or -1 (1 is forward, -1 is backward)
func (r *Robot) Move(reverse int) {
	d := getDirection(r.direction)
	r.r += d[0] * reverse
	r.c += d[1] * reverse
}

func NewRobot(r, c, d int) *Robot {
	return &Robot{
		r:         r,
		c:         c,
		direction: d,
	}
}

func solution(input io.Reader) int {
	scanner := bufio.NewScanner(input)

	scanner.Scan()
	nm := strings.Split(scanner.Text(), " ")
	m := NewMap(atoi(nm[0]), atoi(nm[1]))

	scanner.Scan()
	rcd := strings.Split(scanner.Text(), " ")
	robot := NewRobot(atoi(rcd[0]), atoi(rcd[1]), atoi(rcd[2]))

	for i := 0; i < m.y; i++ {
		scanner.Scan()
		line := strings.Split(scanner.Text(), " ")
		for j, cell := range line {
			m.m[i][j][0] = cell == "1"
		}
	}

	for {
		if !m.IsCleared(robot.r, robot.c) {
			m.Clean(robot.r, robot.c)
		}

		if m.HasUncleared(robot.r, robot.c) {
			for {
				robot.TurnLeft()
				nr, nc := robot.GetNextRC()
				if !m.IsCleanable(nr, nc) {
					continue
				}
				robot.Move(1)
				break
			}
		} else {
			br, bc := robot.GetBackwardRC()
			if !m.IsValidRC(br, bc) || m.IsWall(br, bc) {
				break
			}

			robot.Move(-1)
		}
	}
	return m.cleaned
}

func main() {
	fmt.Print(solution(os.Stdin))
}
