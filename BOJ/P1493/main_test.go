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
		{"4 4 8\n3\n0 10\n1 10\n2 1", 9},
		{"4 4 8\n3\n0 10\n1 10\n2 10", 2},
		{"10 10 11\n1\n0 2000", 1100},
		{"10 10 11\n1\n0 1099", -1},
		{"37 42 59\n6\n0 143821\n1 14382\n2 1438\n3 143\n4 14\n5 1", 5061},
	}

	for i, test := range testSet {
		ret := Solution(strings.NewReader(test.in))
		if ret != test.out {
			t.Errorf("#%d expect %v, got %v", i, test.out, ret)
		}
	}
}
