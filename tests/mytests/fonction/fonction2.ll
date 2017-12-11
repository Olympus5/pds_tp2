; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* nocapture, ...)
; External declaration of the scanf function
declare i32 @scanf(i8* nocapture, ...)

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

define void @fact(i32 %n){
entry2: 
%n1 = alloca i32
%test = alloca i32
%tmp3 = load i32, i32* %n1
store i32 %tmp3, i32* %test
ret void 
}


