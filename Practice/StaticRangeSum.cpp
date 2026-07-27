#include <iostream>

using namespace std;

int main() {
    int N;
    int Q;
    cin >> N >> Q;
    long long preSum[N + 1];
    for (int i = 1; i <= N; i++) {
        int val;
        cin >> val;
        preSum[i] = preSum[i - 1] + val;
    }
    while (Q > 0) {
        long long a,b;
        cin >> a >> b;
        cout<<(preSum[b] - preSum[a - 1]) << endl;
        Q--;
    }
}