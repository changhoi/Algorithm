package main

import "testing"

func TestSolution(t *testing.T) {
	testSet := []struct {
		in  string
		out int
	}{
		{"10101111\n01111101\n11001110\n00000010\n2\n3 -1\n1 1", 7},
		{"11111111\n11111111\n11111111\n11111111\n3\n1 1\n2 1\n3 1", 15},
		{"10001011\n10000011\n01011011\n00111101\n5\n1 1\n2 1\n3 1\n4 1\n1 -1", 6},
		{"10010011\n01010011\n11100011\n01010101\n8\n1 1\n2 1\n3 1\n4 1\n1 -1\n2 -1\n3 -1\n4 -1", 5},
	}

	for i, test := range testSet {
		ret := solution(test.in)
		if ret != test.out {
			t.Errorf("#%d expect: %v, output: %v", i, test.out, ret)
		}
	}
}
