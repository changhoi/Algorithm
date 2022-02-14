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
		{"3 3\n1 1 0\n1 1 1\n1 0 1\n1 1 1", 1},
		{"11 10\n7 4 0\n1 1 1 1 1 1 1 1 1 1\n1 0 0 0 0 0 0 0 0 1\n1 0 0 0 1 1 1 1 0 1\n1 0 0 1 1 0 0 0 0 1\n1 0 1 1 0 0 0 0 0 1\n1 0 0 0 0 0 0 0 0 1\n1 0 0 0 0 0 0 1 0 1\n1 0 0 0 0 0 1 1 0 1\n1 0 0 0 0 0 1 1 0 1\n1 0 0 0 0 0 0 0 0 1\n1 1 1 1 1 1 1 1 1 1", 57},
	}

	for i, test := range testSet {
		ret := solution(strings.NewReader(test.in))
		if ret != test.out {
			t.Errorf("#%d: expect: %v, output: %v", i+1, test.out, ret)
		}
	}
}
