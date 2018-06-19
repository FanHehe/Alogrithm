template <class T>
class Heap {

protected: 
	T* data;
	int length;
	int capatity;
	
public:
	T remove ();
	int add (T);
	void shiftUp (int);
	void shiftDown (int);
	void init ();

	Heap (int n) {
		length = 0;
		data = new T[capatity];
		capatity =  n > 0 ? n + 1 : 100;
	}

	~Heap () {
		delete(data);
	}
	
};
