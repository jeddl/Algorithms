package data_structure

import (
	"errors"
)

type Item interface {
	Weight() int
}

// Heap (Array / binary tree) based priority queue
type Heap[T Item] interface {
	Push(item T)
	Pop() (T, error)
	Size() int
}

type MaxHeap[T Item] struct {
	container []T
}

func NewMaxHeap[T Item]() *MaxHeap[T] {
	return &MaxHeap[T]{}
}

func (m *MaxHeap[T]) Size() int {
	return len(m.container)
}

func (m *MaxHeap[T]) Push(item T) {
	m.container = append(m.container, item)
	m.maxHeapifyUp(m.Size() - 1)
}

func (m *MaxHeap[T]) Pop() (T, error) {
	var item T
	if m.Size() == 0 {
		return item, errors.New("error: heap is empty")
	}

	item = m.container[0]
	length := len(m.container)
	m.container[0] = m.container[length-1]
	m.container = m.container[:length-1]

	m.maxHeapifyDown(0)

	return item, nil
}

func (m *MaxHeap[T]) maxHeapifyUp(pos int) {
	for m.container[parent(pos)].Weight() < m.container[pos].Weight() {
		m.container[parent(pos)], m.container[pos] = m.container[pos], m.container[parent(pos)]
		pos = parent(pos)
	}
}

func (m *MaxHeap[T]) maxHeapifyDown(pos int) {
	l, r := left(pos), right(pos)
	// loop while there's a child
	for l < len(m.container) {
		var targetChild int
		// if the left child is the only child || left child has the larger weight
		if l == len(m.container)-1 || m.container[l].Weight() > m.container[r].Weight() {
			targetChild = l
		} else {
			targetChild = r
		}

		if m.container[pos].Weight() >= m.container[targetChild].Weight() {
			return
		}

		m.container[pos], m.container[targetChild] = m.container[targetChild], m.container[pos]
		pos = targetChild
		l, r = left(pos), right(pos)
	}
}

type MinHeap[I Item] struct {
	container []I
}

// parent finds the parent item index
func parent(currIdx int) int {
	return (currIdx - 1) / 2
}

// left finds the left child index
func left(currIdx int) int {
	return currIdx*2 + 1
}

// right finds the right child index
func right(currIdx int) int {
	return currIdx*2 + 2
}
