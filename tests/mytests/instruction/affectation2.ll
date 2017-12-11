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
%test = alloca i32
%tab = alloca i32, i32 2
call i32 @zero(i32 10)
store i32 10, i32* %test
%tmp1 = load i32, i32* %test
%tmp2 = sub i32 %tmp1, 2
%tmp3 = getelementptr i32,i32* %tab, i32 1
store i32 %tmp2, i32* %tmp3
ret void 
}

define i32 @zero(i32 %n){
entry2: 
%return = alloca i32
%n1 = alloca i32
%tmp5 = load i32, i32* %n1
%tmp6 = icmp ne i32 %tmp5, 0
br i1 %tmp6, label %if3, label %else4
if3: 
%tmp8 = load i32, i32* %n1
%tmp9 = sub i32 %tmp8, 1
%tmp7 = call i32 @zero(i32 %tmp9)
store i32 %tmp7, i32* %return
br label %fi5
else4: 
%tmp10 = load i32, i32* %n1
store i32 %tmp10, i32* %return
br label %fi5
fi5: 
%tmp4 = load i32, i32* %return
ret i32 %tmp4
}


