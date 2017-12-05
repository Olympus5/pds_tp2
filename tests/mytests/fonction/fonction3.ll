; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins

; ModuleID = ’main’

define i32 @main(){
entry1: 
%return = alloca i32
%test = alloca i32
%tmp2 = sub i32 10, 2
store i32 %tmp2, i32* %test
%tmp1 = load i32, i32* %return
ret i32 %tmp1
}

define i32 @fact(i32 %n){
entry2: 
%return = alloca i32
%n1 = alloca i32
%test = alloca i32
%tmp4 = load i32, i32* %n1
store i32 %tmp4, i32* %test
%tmp5 = load i32, i32* %n1
%tmp6 = sub i32 %tmp5, 30
%tmp7 = load i32, i32* %n1
%tmp8 = mul i32 %tmp6, %tmp7
store i32 %tmp8, i32* %return
%tmp3 = load i32, i32* %return
ret i32 %tmp3
}


