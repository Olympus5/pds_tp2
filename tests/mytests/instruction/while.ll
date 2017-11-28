; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%test = alloca i32
%test1 = alloca i32
store i32 10, i32* %test1
br label %while1
while1: 
%tmp1 = load i32, i32* %test1
%tmp2 = icmp ne i32 %tmp1, 0
br i1 %tmp2, label %do2, label %done3
do2: 
%tmp3 = load i32, i32* %test1
%tmp4 = sub i32 %tmp3, 1
store i32 %tmp4, i32* %test1
%tmp5 = load i32, i32* %test1
%tmp6 = add i32 %tmp5, 1
store i32 %tmp6, i32* %test
ret i32 0
br label %while1
done3: 
ret i32 0
}

