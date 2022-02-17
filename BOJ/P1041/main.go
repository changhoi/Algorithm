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

func atoi(s string) int {
	ret, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}
	return ret
}

func min(values ...int) int {
	minValue := math.MaxInt
	for _, v := range values {
		if minValue > v {
			minValue = v
		}
	}

	return minValue
}

func max(values ...int) int {
	maxValue := math.MinInt
	for _, v := range values {
		if maxValue < v {
			maxValue = v
		}
	}

	return maxValue
}

func solution(input io.Reader) uint64 {
	scanner := bufio.NewScanner(input)
	scanner.Scan()
	n := atoi(scanner.Text())

	scanner.Scan()
	cube := make([]int, 6)

	for i, cell := range strings.Split(scanner.Text(), " ") {
		cube[i] = atoi(cell)
	}

	if n == 1 {
		return uint64(cube[0] + cube[1] + cube[2] + cube[3] + cube[4] + cube[5] - max(cube...))
	}

	minAF := min(cube[0], cube[5])
	minBE := min(cube[1], cube[4])
	minCD := min(cube[2], cube[3])

	one := min(minAF, minBE, minCD)
	two := min(minAF+minBE, minAF+minCD, minCD+minBE)
	three := minAF + minBE + minCD

	var sum uint64 = 0

	totalTwo := 4*(n-2) + 4*(n-1)
	totalThree := 4
	totalOne := 4*(n-1)*(n-2) + (n-2)*(n-2)

	sum += uint64(totalOne*one) + uint64(totalTwo*two) + uint64(totalThree*three)
	return sum
}

func main() {
	fmt.Println(solution(os.Stdin))
}
