#include<iostream>
#include<map>
#include<vector>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCase, n, q;
    cin >> testCase;
    for(int t = 1; t <= testCase; t++){
        cout << "Case " << t << ":\n";
        cin >> n >> q;
        vector<int> array(n+1);
        map<int, vector<int>> indices;
        for(int i = 1; i <= n; i++){
            int x;
            cin >> x;
            array[i] = x;
            indices[x].push_back(i);
        }
        while(q--){
            int c, x, y;
            cin >> c;
            if(c == 1){
                cin >> x >> y;
                if(x == y)continue;
                for(int k : indices[x])array[k] = y;
                indices[y].insert(indices[y].end(), indices[x].begin(), indices[x].end());
                indices.erase(x);
            }
            else{
                cin >> x;
                cout << array[x] << endl;
            }
        }
    }
    return 0;
}