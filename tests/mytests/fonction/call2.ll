; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* nocapture, ...)
; External declaration of the scanf function
declare i32 @scanf(i8* nocapture, ...)

; Actual code begins

; ModuleID = ’main’

define void @main(){
entry1: 
call void @fact(i32 10)
ret void 
}

define void @fact(i32 %n){
entry2: 
%n1 = alloca i32
%test = alloca i32
%tmp1 = load i32, i32* %n1
store i32 %tmp1, i32* %test
ret void 
}


