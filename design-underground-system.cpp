// Problem link: https://leetcode.com/problems/design-underground-system/
// Time complexity: checkIn -> O(1), checkOut -> O(1), getAverageTime -> O(1)
// Space complexity: O(N + (S^S))

class UndergroundSystem {
public:
    unordered_map<int, pair<string, int>> inTravel;
    unordered_map<string, unordered_map<string, pair<int, int>>> time;
    UndergroundSystem() { 
    }
    
    void checkIn(int id, string stationName, int t) {
        inTravel[id] = {stationName, t};
    }
    
    void checkOut(int id, string stationName, int t) {
        pair<string, int> data = inTravel[id];
        time[data.first][stationName].first += t - data.second;
        cout<<time[data.first][stationName].first<<endl;
        time[data.first][stationName].second += 1;
    }
    
    double getAverageTime(string startStation, string endStation) {
        return time[startStation][endStation].first*1.0 / time[startStation][endStation].second;
    }
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */
