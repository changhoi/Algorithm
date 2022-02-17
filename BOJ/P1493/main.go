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

func Solution(input io.Reader) int {
	scanner := bufio.NewScanner(input)
	scanner.Scan()

	lwh := strings.Split(scanner.Text(), " ")
	length := atoi(lwh[0])
	width := atoi(lwh[1])
	height := atoi(lwh[2])

	scanner.Scan()
	n := atoi(scanner.Text())

	var cubes [20]int

	for i := 0; i < n; i++ {
		scanner.Scan()
		ab := strings.Split(scanner.Text(), " ")
		k := atoi(ab[0])
		v := atoi(ab[1])
		cubes[k] = v
	}

	before := 0
	ans := 0
	for i := 19; i >= 0; i-- {
		before <<= 3
		possibleCube := (length>>i)*(width>>i)*(height>>i) - before
		newCube := int(math.Min(float64(cubes[i]), float64(possibleCube)))

		before += newCube
		ans += newCube
	}

	if before == length*width*height {
		return ans
	}
	return -1
}

func main() {
	fmt.Println(Solution(os.Stdin))
}
