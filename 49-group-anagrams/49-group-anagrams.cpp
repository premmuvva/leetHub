class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> an;
        string temp;
        unordered_map<string,vector<string>> m;
        for (string &it :strs){
            temp=it;
            sort(it.begin(),it.end());
            m[it].push_back(temp);
        }
        for (auto it :m)
            an.push_back(it.second);
        return an;
    }
};