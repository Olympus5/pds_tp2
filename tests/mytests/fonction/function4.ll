; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins

; ModuleID = ’main’

define void @main(){
entry1: 
%test = alloca i32
%tmp1 = sub i32 10, 2
store i32 %tmp1, i32* %test
ret void 
}

define void @fact(i32 %n){
entry2: 
%n1 = alloca i32
%test = alloca i32
%tmp2 = load i32, i32* %n1
store i32 %tmp2, i32* %test
ret void 
}


