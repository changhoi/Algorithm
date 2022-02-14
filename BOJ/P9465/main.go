package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func atoi(s string) int {
	ret, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}
	return ret
}

func rtoi(r rune) int {
	return atoi(string(r))
}

func calc(x1, y1, x2, y2 int) int {
	return (x2 - x1 + 1) * (y2 - y1 + 1)
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	condition := scanner.Text()
	yx := strings.Split(condition, " ")
	y := atoi(yx[0])
	x := atoi(yx[1])

	table := make([][]int, y)

	for i := 0; i < y; i++ {
		scanner.Scan()
		l := scanner.Text()
		table[i] = make([]int, x)
		for j, cell := range l {
			table[i][j] = rtoi(cell)
		}
	}

	max := 1

	for i := 0; i < y; i++ {
		for j := 0; j < x; j++ {
			val := table[i][j]

			for k := 0; k < x-j; k++ {
				right := j + k

				if table[i][right] != val {
					continue
				}

				bottom := i + k

				if bottom >= y {
					break
				}

				if table[bottom][right] != val || table[bottom][j] != val {
					continue
				}

				area := calc(j, i, right, bottom)
				if area > max {
					max = area
				}
			}
		}
	}

	fmt.Print(max)
}
