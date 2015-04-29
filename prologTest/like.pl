%atoms for each class
course(cosc117).
course(cosc120).
course(math201).
course(math202).
course(math210).
course(cosc220).
course(cosc250).
course(math293).
course(cosc320).
course(cosc330).
course(cosc350).
course(cosc362).
course(cosc370).
course(cosc386).
course(cosc420).
course(cosc422).
course(cosc425).
course(cosc426).
course(cosc432).
course(cosc450).
course(cosc456).
course(math471).
course(cosc472).
course(cosc482).

%prerequisets for all classes
prereq(cosc120, [cosc117]).
prereq(math202, [math201]).
prereq(cosc220, [cosc120]).
prereq(cosc250, [cosc117, 250]). 
%prereq(cosc250, [cosc120]).
prereq(math293, [math202]).
prereq(cosc320, [cosc220, math210]).
%prereq(cosc320, [math210]).
prereq(cosc330, [cosc220]).
prereq(cosc350, [cosc250, cosc220]).
%prereq(cosc350, [cosc220]).
prereq(cosc362, [math210, cosc120]).
%prereq(cosc362, [cosc120]).
prereq(cosc370, [math210, cosc220]).
%prereq(cosc370, [cosc220]).
prereq(cosc386, [math210, cosc220]).
%prereq(cosc386, [cosc220]).
prereq(cosc420, [cosc320]).
prereq(cosc422, [cosc220]).
prereq(cosc425, [cosc320]).
prereq(cosc426, [cosc425]).
prereq(cosc432, [cosc320]).
prereq(cosc450, [cosc350]).
prereq(cosc456, [cosc250, cosc250]).
%prereq(cosc456, [cosc250]).
prereq(math471, [cosc117, math293]).
%prereq(math471, [math293]).
prereq(cosc472, [cosc370]).
prereq(cosc482, [math293, cosc120]).
%prereq(cosc482, [cosc120]).









%test code
fun(X):-
red(X),
car(X).
fun(X):-
blue(X),
bike(X).
car(vw_beatle).
car(ford_escort).
bike(harley_davidson).
red(vw_beatle).
red(ford_escort).
blue(harley_davidson).

likes(X):-rob(X).
rob([beer,money,fun]).
rob([1,2,3,4,5,6]).
rob(money).
rob([1,2,3]):-rob(X).

parent(pam,bob).
parent(tom,bob).
parent(tom,liz).
parent(bob,ann).
parent(bob,pat).
parent(pat,jim).
female(pam).

female(liz).
female(pat).
female(ann).

offspring(Y, X):-parent( X, Y).

male(X):-female(X).

processList([],[]). 
processList([A|L],[string(A)|LL]):-female(A), parent(L,LL). 

parent([],[]).
parent([A|L],[string(A)|LL]):-rob(A),parent(L,LL).

