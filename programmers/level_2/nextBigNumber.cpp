#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

string getBin(int n) {
    string bin = "";
    while(n/2 != 0) {
        bin += to_string(n%2);
        n /= 2;
    }
    bin += to_string(n);
    reverse(bin.begin(), bin.end());
    return bin;
}
int getOne(string bin) {
    int one = 0;
    for(int i=0; i<bin.length(); i++) {
        if(bin[i] == '1') one++;
    }
    return one;
}

int solution(int n) {
    int answer = 0;
    int one = getOne(getBin(n));
    for(int i=n+1; i<=1000000; i++) {
        int tmp = getOne(getBin(i));
        answer = i;
        if(tmp == one) break;
    }
    
    return answer;
}