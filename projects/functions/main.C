#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
#include <unistd.h>
void wlc();
void getnum(unsigned*);
void getOP(unsigned*);//Ordered pair
void option(unsigned*);
void reflexive();
void conjunctive();
void transitivity();
void andfunc();
void orfunc();
void a_b();
void b_a();

int main(){
    unsigned *num = NULL;
    wlc();
    scanf("%d",num);
    getnum(num);
    getOP(num);


    return 0;
}
void wlc(){
    printf("welcom to gosaste 2nd project!\n");
    printf("If you want to check reflexive,conjunctive or transivity ENTER 1,\n");
    printf("If you want to check &&,|| or Difference of two sets ENTER 2\n");
}
void getnum(unsigned num){
    switch (num) {
    case 1:
        printf("you choose 1,so enter one set\n");
        break;
    case 2:
        printf("you choose 2,so enter two sets\n");
        break;
    default:
        printf("Incorrect input\n");
    }
}
void getOP(unsigned num){
    if (num==1){
    unsigned n;
    printf("how many Ordered pair do you want?\n");
    scanf("%d",&n);
    int arr1[2*n];
    for(unsigned i=0;i<(2*n);i++){
        scanf("%d",&arr1[i]);
    }
    system("CLS");

    for(unsigned i=0;i<(2*n);i+=2){
        printf("(%d,%d)\t",arr1[i],arr1[i+1]);
    }
    }

    else {
        unsigned n;
        unsigned m;
        printf("now you should enter first set...\n");
        printf("how many Ordered pair do you want?\n");
        scanf("%d",&n);
        int *arr1[2*n];
        *arr1=(int*)malloc(sizeof (int));

        for(unsigned i=0;i<(2*n);i++){
            scanf("%d",arr1[i]);
        }
        system("CLS");

        for(unsigned i=0;i<(2*n);i+=2){
            printf("(%d,%d)\t",*arr1[i],*arr1[i+1]);
        }

        printf("\nnow you should enter second set...");
        printf("\nhow many Ordered pair do you want?\n");
        scanf("%d",&m);


        int *arr2[2*m];
        *arr2=(int*)malloc(sizeof (int));
        for(unsigned i=0;i<(2*m);i++){
            scanf("%d",arr2[i]);
        }
        for(unsigned i=0;i<(2*m);i+=2){
            printf("(%d,%d)\t",*arr2[i],*arr2[i+1]);
        }
        printf("\n");
    }
}
void option(unsigned num){
    int opno;
    if(num==1){
        printf("Enter 1=to check reflexive/n      2=to check conjunctive\n      3=to check transitivity\n");
        scanf("%d",&opno);
        switch (opno) {
        case 1:
            reflexive();
        case 2:
            conjunctive();
        case 3:
            transitivity();
        default:
            printf("Incorrect input!\n");


        }
    }

    else{
        printf("Enter 1=to check a&b /n      2=to check a|b\n      3=to check a-b\n      4=to check b-a\n");
        scanf("%d",&opno);
        switch (opno) {
        case 1:
            andfunc();
        case 2:
            orfunc();
        case 3:
            a_b();
        case 4:
            b_a();
        default:
            printf("Incorrect input!\n");
        }
}
}
