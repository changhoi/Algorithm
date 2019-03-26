#include <iostream>
#include <set>
using namespace std;
bool isIn(set<int> &s, int month);

int main() {
	int month, day, date;
	cin >> month >> date;
	set<int> thirty = { 4, 6, 9, 11 };
	set<int> thirtyOne = { 1, 3, 5, 7, 8, 10, 12 };
	int temp = 0;
	while (--month) {
		if (isIn(thirty, month)) {
			temp += 30;
		}
		else if (isIn(thirtyOne, month)) {
			temp += 31;
		}
		else {
			temp += 28;
		}
	}
	temp += date;
	day = temp % 7;
	char* result;
	switch (day) {
	case 1: {result = "MON"; break; }
	case 2: {result = "TUE"; break; }
	case 3: {result = "WED"; break; }
	case 4: {result = "THU"; break; }
	case 5: {result = "FRI"; break; }
	case 6: {result = "SAT"; break; }
	case 0: {result = "SUN"; break; }
	}
	printf("%s\n", result);

	
	return 0;
}

bool isIn(set<int> &s, int month) {
	auto it = s.find(month);
	if (it == s.end()) return false;
	else return true;
}