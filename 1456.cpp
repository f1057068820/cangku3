#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int tp[1000000];

long team[1000][1000];

int t1[1000]={0};
int t2[1000]={0};
int st,ed;

int main()
{
    int t_q;
    int t_s=0;
    int t_m;
    int p;
    long t_e;
    char s[20];
    bool flag;
    while(scanf("%d", &t_q),t_q!=0)
    {
          st=0;
          ed=0;
          for(int i=0; i<1000; i++)
            {
                  t1[i]=0;
                  t2[i]=0;
            }
          printf("Scenario #%d\n", ++t_s);
          for(int i=0; i<t_q; i++)
            {
                  scanf("%d", &t_m);
                      for(int j=0; j<t_m; j++)
                       {
                           scanf("%d", &p);
                           tp[p]=i+1;
                       }
            }  
           do
           {
               scanf("%s", s);
               flag=false;
               if(s[0]=='S')break;
               if(s[0]=='E')
               {
                         scanf("%ld", &t_e);
                         for(p=st; p<ed; p++)
                           {
                                 if(tp[team[p][t1[p]]]==tp[t_e])
                                 {
                                                 flag=true;
                                                 break;               
                                 }
                           } 
                         if(flag)
                         {
                                 team[p][t2[p]]=t_e;
                                 t2[p]=(t2[p]+1)%1000;
                         }  
                         else
                         {
                             team[ed][t1[ed]]=t_e;
                             t2[ed]=(t2[ed]+1)%1000;
                             ed=(ed+1)%1000;
                         }               
               }
               if(s[0]=='D')
               {
                         printf("%ld\n", team[st][t1[st]]);
                         t1[st]=(t1[st]+1)%1000;
                         if(t1[st]==t2[st])st++;   
               }
               
           }while(s[0]!='S');           
           printf("\n");
    }
    return 0;
}