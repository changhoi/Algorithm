package main

import (
	"strings"
	"testing"
)

func TestSolution(t *testing.T) {
	testSet := []struct {
		in  string
		out uint64
	}{
		{"2\n1 2 3 4 5 6", 36},
		{"3\n1 2 3 4 5 6", 69},
		{"1000000\n50 50 50 50 50 50", 250000000000000},
		{"10\n1 1 1 1 50 1", 500},
	}

	for i, test := range testSet {
		ret := solution(strings.NewReader(test.in))
		if ret != test.out {
			t.Errorf("#%d expect %v, got %v", i, test.out, ret)
		}
	}
}
