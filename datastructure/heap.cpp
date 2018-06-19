#include "heap.h"

template <class T>
void Heap<T>::shiftUp (int i) {}

template <class T>
void Heap<T>::shiftDown (int i) {}

template <class T>
int Heap<T>::add (T item) {
	if (length + 1 >= capicity - 1) return false;

	data[++length] = item;
}

template <class T>
T Heap<T>::remove() {}

template <class T>
void Heap<T>::init () {

}

int main () {
	Heap<int>* heap = new Heap<int>(100);

	// 5,11,7,2,3,17
	heap->add(5);
	heap->add(11);
	heap->add(7);
	heap->add(2);
	heap->add(3);
	heap->add(17);
}