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
%tab = alloca i32, i32 11
store i32 10, i32* %return
%tmp1 = load i32, i32* %return
ret i32 %tmp1
}


