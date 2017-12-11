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
%test = alloca i32, i32 4
%tmp1 = getelementptr i32,i32* %test, i32 0
%tmp2 = load i32, i32* %tmp1
call void @fact(i32 %tmp2)
ret void 
}

define void @fact(i32 %n){
entry2: 
%n1 = alloca i32
%test = alloca i32
%tmp3 = load i32, i32* %n1
store i32 %tmp3, i32* %test
ret void 
}


