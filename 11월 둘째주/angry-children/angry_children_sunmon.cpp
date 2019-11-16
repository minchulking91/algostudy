#define MIN(a,b) (a<b)?a:b;
using namespace std;

int nonDivisibleSubset(int k, vector<int> s) {
    
    for(auto& a: s) a= a%k;
    int subset = MIN(1, count(s.begin(), s.end(), 0));
    
    for(int i = 1; i<= (k/2); i++)
    {
        int num = count(s.begin(), s.end(), i);
        int opposit = count(s.begin(), s.end(), k-i);
        if(i == k-i) num=opposit=1;
        num > opposit? subset += num : subset += opposit;
    }
    return subset;
}
