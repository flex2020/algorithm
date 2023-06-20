#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string arr[3] = {"4", "1", "2"};

string solution(int n) {
    string answer = "";
    if(n <= 3) answer = arr[n%3];
    else {
        while(n/3 > 0) {
            if(n%3 == 0) n -= 3;
            answer += arr[n%3];
            n /= 3;
        }
        if(n != 0) answer += arr[n];
        reverse(answer.begin(), answer.end());
    }

    return answer;
}