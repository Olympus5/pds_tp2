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
%tab = alloca i32, i32 11
%"tab[2]" = getelementptr i32,i32* %tab, i32 2
%tmp2 = load i32, i32* %"tab[2]"
%tmp3 = load i32, i32* %test
%"tab[%tmp3]" = getelementptr i32,i32* %tab, i32 %tmp3
%tmp4 = load i32, i32* %"tab[%tmp3]"
%tmp5 = load i32, i32* %test
%tmp6 = sub i32 %tmp5, 3
%tmp7 = mul i32 %tmp6, 4
%"tab[%tmp7]" = getelementptr i32,i32* %tab, i32 %tmp7
%tmp8 = load i32, i32* %"tab[%tmp7]"
%tmp9 = add i32 %tmp4, %tmp8
%tmp10 = add i32 %tmp2, %tmp9
store i32 %tmp10, i32* %test
store i32 10, i32* %return
%tmp1 = load i32, i32* %return
ret i32 %tmp1
}


