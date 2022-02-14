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
	defaultTop   = 0
	defaultRight = 2
	defaultLeft  = 6
)

type Gear struct {
	teeth               [8]int
	right, left, top    int
	leftGear, rightGear *Gear
}

func (g *Gear) GetTop() int {
	return g.teeth[g.top]
}

func (g *Gear) GetLeft() int {
	return g.teeth[g.left]
}

func (g *Gear) GetRight() int {
	return g.teeth[g.right]
}

func (g *Gear) Rotate(d int, from *Gear) {
	g.propagate(d, from)
	g.right -= d
	g.left -= d
	g.top -= d
	if g.right < 0 {
		g.right = 7
	}

	if g.left < 0 {
		g.left = 7
	}

	if g.top < 0 {
		g.top = 7
	}

	if g.right > 7 {
		g.right = 0
	}

	if g.left > 7 {
		g.left = 0
	}

	if g.top > 7 {
		g.top = 0
	}
}

func (g *Gear) propagate(d int, from *Gear) {
	if g.leftGear != nil && g.leftGear != from && g.leftGear.GetRight() != g.GetLeft() {
		g.leftGear.Rotate(d*-1, g)
	}

	if g.rightGear != nil && g.rightGear != from && g.rightGear.GetLeft() != g.GetRight() {
		g.rightGear.Rotate(d*-1, g)
	}
}

func atoi(s string) int {
	ret, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}

	return ret
}

func InitGear(line string) *Gear {
	var g Gear
	for i, r := range line {
		g.teeth[i] = atoi(string(r))
	}

	g.top = defaultTop
	g.left = defaultLeft
	g.right = defaultRight

	return &g
}

func solution(txt string) int {
	scanner := bufio.NewScanner(strings.NewReader(txt))
	var gears [4]*Gear

	for i := 0; i < 4; i++ {
		scanner.Scan()
		gears[i] = InitGear(scanner.Text())
	}

	gears[0].rightGear = gears[1]

	gears[1].leftGear = gears[0]
	gears[1].rightGear = gears[2]

	gears[2].leftGear = gears[1]
	gears[2].rightGear = gears[3]

	gears[3].leftGear = gears[2]

	scanner.Scan()
	n := atoi(scanner.Text())

	for i := 0; i < n; i++ {
		scanner.Scan()
		line := strings.Split(scanner.Text(), " ")
		gIdx := atoi(line[0]) - 1
		direction := atoi(line[1])
		gears[gIdx].Rotate(direction, gears[gIdx])
	}

	ret := 0

	for i, g := range gears {
		top := g.GetTop()
		ret += top << i
	}

	return ret
}

func main() {
	txt, err := io.ReadAll(os.Stdin)
	if err != nil {
		panic(err)
	}

	fmt.Print(solution(string(txt)))
}
