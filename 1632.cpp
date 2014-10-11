#include<iostream>
#include<climits> 
#include<stdio.h>
#include<string>
using namespace std;
int A[100][100];
void prim(int n);
int main()
{
        int n;
        cin>>n;
        while(n!=0)
        {

                for(int i=0;i<100;i++)
                {
                        for(int j=0;j<100;j++)
                        {
                                A[i][j]=-1;
                        }
                }
                for(int i=0;i<n-1;i++)
                {
                        char a;
                        int b;
                        cin>>a>>b;
                        for(int j=0;j<b;j++)
                        {
                                char c;
                                int d;
                                cin>>c>>d;
                                A[a-'A'][c-'A']=d;
                                A[c-'A'][a-'A']=d;
                        }
                        getchar();
                }
                prim(n);
                scanf("%d",&n);
                
        }
        return 0;
}
void prim(int n)  
{  
        int sum=0;  
        int *temp=new int[n];  
        int index=-1;  
        temp[++index]=0;       
        while(index<n-1)  
        {  
                int min=INT_MAX;  
                int t=INT_MAX;  
                for(int i=0;i<=index;i++)  
                {  
                        for(int j=1;j<n;j++)  
                        {  
                                bool tag=true;  
                                for(int k=0;k<=index;k++)  
                                {  
                                        if(j==temp[k])  
                                        {  
                                                tag=false;  
                                                break;  
                                        }  
                                }  
                                if(tag)  
                                {  
                                        if(A[temp[i]][j]!=-1&&A[temp[i]][j]<min)  
                                        {  
                                                min=A[temp[i]][j];  
                                                t=j;  
                                        }  
                                }  
                        }  
                }  
                temp[++index]=t;  
                sum=min+sum;  
        }  
        printf("%d\n",sum);  
}   