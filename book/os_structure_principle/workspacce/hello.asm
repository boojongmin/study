section .data
                        ;���⿡�� �����͸� �ִ� �� �Դϴ�.
msg db "hello world",0x0A
                        ; hello world ��� �ܾ�� ���� �̶�� 16���� �ڵ�
section .text

global _start
  
_start
mov eax,4          ; write�� �ý��� �� ��ȣ
mov ebx,1          ; write�� ǥ�� ����� 1���̴�.
mov ecx,msg      ; write�� �� ���� ���ڿ� �޼��� �ּ� ����
mov edx,12        ; write �� �� ���� ���ڿ� ���ڿ� ���� ����
int 0x80             ; ����

mov eax,1         ; exit�� �ý��� �� ��ȣ
mov ebx,0         ; exit�� �������� ����
int 0x80             ; ����
