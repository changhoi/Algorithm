package main

import (
	"bufio"
	"fmt"
	"io"
	"math"
	"os"
	"strconv"
	"strings"
)

var direction = [4][2]int{
	{0, 1},
	{1, 0},
	{0, -1},
	{-1, 0},
}

func atoi(s string) int {
	ret, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}

	return ret
}

type Pair struct {
	r, c int
}

type Set map[Pair]int

func (s Set) GetMin() (Pair, int) {
	min := math.MaxInt
	var pair Pair
	for k, v := range s {
		if min > v {
			min = v
			pair = k
		}
	}

	if min != math.MaxInt {
		delete(s, pair)
	}

	return pair, min
}

func (s Set) Add(p Pair, dist int) {
	v, ok := s[p]
	if !ok {
		s[p] = dist
	} else if v > dist {
		s[p] = dist
	}
}

type Map struct {
	n, m  int
	table [][][2]bool
}

func (m *Map) IsValidRC(r, c int) bool {
	return 0 <= r && r < m.n && 0 <= c && c < m.m
}

func (m *Map) IsWall(r, c int) bool {
	return m.table[r][c][0]
}

func (m *Map) IsVisited(r, c int) bool {
	return m.table[r][c][1]
}

func (m *Map) Visit(r, c int) {
	m.table[r][c][1] = true
}

func (m *Map) Walk(r, c int, fn func(int, int, bool)) {
	for _, d := range direction {
		nr := r + d[0]
		nc := c + d[1]
		if !m.IsValidRC(nr, nc) || m.IsVisited(nr, nc) {
			continue
		}

		fn(nr, nc, m.IsWall(nr, nc))
	}
}

func (m *Map) IsDestination(r, c int) bool {
	return m.n-1 == r && m.m-1 == c
}

func NewMap(n, m int, table [][][2]bool) *Map {
	return &Map{
		n:     n,
		m:     m,
		table: table,
	}
}

func solution(input io.Reader) int {
	scanner := bufio.NewScanner(input)

	scanner.Scan()
	mn := strings.Split(scanner.Text(), " ")
	m := atoi(mn[0])
	n := atoi(mn[1])

	table := make([][][2]bool, n)
	for i := 0; i < n; i++ {
		table[i] = make([][2]bool, m)
		scanner.Scan()
		line := scanner.Text()
		for j, cell := range line {
			table[i][j][0] = string(cell) == "1"
		}
	}

	maze := NewMap(n, m, table)
	set := Set{
		Pair{
			r: 0,
			c: 0,
		}: 0,
	}

	for {
		pair, min := set.GetMin()
		if min == math.MaxInt {
			break
		}

		if maze.IsDestination(pair.r, pair.c) {
			return min
		}

		maze.Walk(pair.r, pair.c, func(r int, c int, isWall bool) {
			p := Pair{
				r: r,
				c: c,
			}
			if isWall {
				set.Add(p, min+1)
			} else {
				set.Add(p, min)
			}
		})

		maze.Visit(pair.r, pair.c)
	}

	return -1
}

func main() {
	fmt.Println(solution(os.Stdin))
}
