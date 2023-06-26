#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer = {};
    vector<int> a = {};
    int size = progresses.size();
    for(int i=0; i<size; i++) {
        int tmp = 100 - progresses[i];
        if(tmp%speeds[i] == 0) {
            tmp /= speeds[i];
        } else {
            tmp /= speeds[i];
            tmp++;
        }
        answer.push_back(tmp);
    }
    int max = answer[0], cnt = 1;
    for(int i=1; i<size; i++) {
        if(max < answer[i]) {
            max = answer[i];
            a.push_back(cnt);
            cnt = 1;
        }
        else {
            cnt++;
        }
    }
    a.push_back(cnt);
    
    return a;
}