/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        map<int, pair<int, vector<int>>> ei;
        for(Employee* e: employees) {
            ei[e->id] = {e->importance, e->subordinates};
        }
        queue<int> q;
        q.push(id);
        
        int res = 0;
        while(!q.empty()) {
            int top = q.front();
            q.pop();
            res += ei[top].first;
            for(int i: ei[top].second) {
                q.push(i);
            }
        }
        return res;
    }
};
