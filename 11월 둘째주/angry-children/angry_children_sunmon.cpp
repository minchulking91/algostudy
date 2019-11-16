#define MIN(a,b) (a<b)? a:b

using namespace std;

int maxMin(int k, vector<int> arr) {
    sort(arr.begin(), arr.end());

    int unfair = 987654321;
    for(int i = 0; i<arr.size(); i++)
    {
        if(i + k > arr.size()) break;
        int local_max = arr[i+k-1];
        int local_min = arr[i];

        unfair = MIN(unfair, local_max - local_min);
    }

    return unfair;
}
