package main

import (
	"strings"
	"testing"
)

func TestSolution(t *testing.T) {
	testSet := []struct {
		in  string
		out int
	}{
		{"3 3\n011\n111\n110", 3},
		{"4 2\n0001\n1000", 0},
		{"6 6\n001111\n010000\n001111\n110001\n011010\n100010", 2},
	}

	for i, test := range testSet {
		out := solution(strings.NewReader(test.in))
		if out != test.out {
			t.Errorf("#%d expect %v, get %v", i, test.out, out)
		}
	}
}
