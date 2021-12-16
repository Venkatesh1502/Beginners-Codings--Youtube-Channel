#include<stdio.h>
#include<conio.h>
#include<string.h>
 
void main()
{
char msg[] = "find my reversal i am a sentence";
char str[15];
int i = 0, j = 0;
clrscr(); 
while (msg[i] != '\0')
{
  if (msg[i] != ' ')
  {
  str[j] = msg[i];
  j++;
  } 
else
  {
  str[j] = '\0';
  printf("%s", strrev(str));
  printf(" ");
  j = 0;
  }
i++;
}
 
str[j] = '\0';
printf("%s", strrev(str));
 
getch();
}