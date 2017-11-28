; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%test = alloca i32
%tmp1 = load i32, i32* %test
%tmp2 = sub i32 %tmp1, 1
%tmp3 = icmp ne i32 %tmp2, 0
br i1 %tmp3, label %if1, label %else2
if1: 
store i32 2, i32* %test
ret i32 0
br label %fi3
else2: 
%tmp4 = load i32, i32* %test
%tmp5 = add i32 %tmp4, 1
store i32 %tmp5, i32* %test
%tmp6 = load i32, i32* %test
%tmp7 = add i32 3, %tmp6
%tmp8 = sub i32 2, %tmp7
store i32 %tmp8, i32* %test
ret i32 0
br label %fi3
fi3: 
ret i32 0
}

