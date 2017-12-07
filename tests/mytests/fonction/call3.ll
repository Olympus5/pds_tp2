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
call i32 @zero(i32 10)
ret void 
}

define i32 @zero(i32 %n){
entry2: 
%return = alloca i32
%n1 = alloca i32
%tmp2 = load i32, i32* %n1
%tmp3 = icmp ne i32 %tmp2, 0
br i1 %tmp3, label %if3, label %else4
if3: 
%tmp5 = load i32, i32* %n1
%tmp6 = sub i32 %tmp5, 1
%tmp4 = call i32 @zero(i32 %tmp6)
store i32 %tmp4, i32* %return
br label %fi5
else4: 
%tmp7 = load i32, i32* %n1
store i32 %tmp7, i32* %return
br label %fi5
fi5: 
%tmp1 = load i32, i32* %return
ret i32 %tmp1
}


