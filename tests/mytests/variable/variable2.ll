; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%test = alloca i32
%test1 = alloca i32
%test2 = alloca i32
%tmp1 = sub i32 3, 32
ret i32 %tmp1
}

