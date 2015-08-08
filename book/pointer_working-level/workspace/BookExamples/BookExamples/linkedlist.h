#include <stdio.h>
#include <malloc.h>

struct score {
	int kor;
	int eng;
	struct score* next;
};

typedef struct score SCORE;
SCORE* head;

SCORE* addNode(int kor, int eng);
void printNode(SCORE* head);
SCORE* findNode(int kor, int eng);
void addFirst(int kor, int eng);
SCORE* insertNode(SCORE* node, int kor, int eng);
void deleteAllNode();

void linkedlistRun() {
	head = NULL;

	SCORE *n1, *n2, *n3, *n4;
	n1 = addNode(50, 60);
	n2 = addNode(70, 80);
	n3 = addNode(90, 100);

	addFirst(10, 20);
	insertNode(n2, 80, 90);

	n4 = findNode(50, 60);
	printf("findNode -> kor : %d, eng : %d\n", n4->kor, n4->eng);
	printNode(head);
	deleteAllNode();
	printNode(head);

}

SCORE* addNode(int kor, int eng) {
	SCORE* tmp = NULL;
	SCORE* val = NULL;

	val = (SCORE*)malloc(sizeof(SCORE));
	val->kor = kor;
	val->eng = eng;
	val->next = NULL;

	if (head == NULL) {
		head = val;
		return head;
	}
	else {
		tmp = head;
		while (tmp->next != NULL) {
			tmp = tmp->next;
		}
		tmp->next = val;
		return val;
	}
}

void addFirst(int kor, int eng) {
	SCORE* val = NULL;
	val = (SCORE*)malloc(sizeof(SCORE));
	val->kor = kor;
	val->eng = eng;
	val->next = head;
	head = val;
}

SCORE* insertNode(SCORE* node, int kor, int eng) {
	SCORE* val = NULL;
	val = (SCORE*)malloc(sizeof(SCORE));
	val->kor = kor;
	val->eng = eng;
	val->next = node->next;

	printf("%d\n", node->kor);
	printf("%d\n", node->next->kor);

	node->next = val;
	return val;
}

SCORE* findNode(int kor, int eng) {
	SCORE* tmp = head;
	while (tmp != NULL && (tmp->kor != kor || tmp->eng != eng)) {
		tmp = tmp->next;
	}
	return tmp;
	//SCORE* tmp = NULL;
	//if (head == NULL) return NULL;
	//tmp = head;
	//while (true) {
	//	if (tmp->eng == eng && tmp->kor == kor) {
	//		return tmp;
	//	}
	//	if (tmp->next == NULL) {
	//		return NULL;
	//	}
	//	else {
	//		tmp = tmp->next;
	//	}
	//}
	//return NULL;
}

void printNode(SCORE* head) {
	SCORE* tmp = head;
	printf("printNode\n");
	while (tmp != NULL) {
		printf("kor=%d, eng=%d\n", tmp->kor, tmp->eng);
		tmp = tmp->next;
	}
}

void deleteAllNode() {
	SCORE* tmp = head;
	SCORE* del = NULL;
	while (tmp != NULL) {
		del = tmp;
		tmp = tmp->next;
		free(del);
	}
	head = NULL;
}