#include <iostream>
#include <string>
using namespace std;

int main(int argc, char const *argv[])
{
string s;
cin>>s;
for (int i = s.size()-1; i >= 0; --i)
{
cout<<s[i];
}
cout<<endl;
return 0;
}