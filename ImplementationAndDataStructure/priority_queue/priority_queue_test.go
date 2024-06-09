package data_structure_test

import (
	data_structure "algorithms/data_structures"
	"testing"

	"github.com/stretchr/testify/assert"
)

// type testItem data_structure.Item[int]
type testItem struct {
	item int
}

func (i testItem) Weight() int {
	return i.item
}

func (i testItem) Self() any {
	return i
}

func Test_MaxHeap(t *testing.T) {
	heap := data_structure.NewMaxHeap[testItem]()

	t.Run("Push", func(t *testing.T) {
		assert.Equal(t, 0, heap.Size())

		heap.Push(testItem{1})
		heap.Push(testItem{2})
		assert.Equal(t, 2, heap.Size())

		heap.Push(testItem{6})
		heap.Push(testItem{4})
		heap.Push(testItem{5})
		heap.Push(testItem{3})
		assert.Equal(t, 6, heap.Size())
	})

	t.Run("Pop", func(t *testing.T) {
		assert.Equal(t, 6, heap.Size())

		list := []int{6, 5, 4, 3, 2, 1}
		for _, num := range list {
			val, _ := heap.Pop()
			assert.Equal(t, num, val.Weight())
		}
		_, err := heap.Pop()
		assert.NotNil(t, err)
	})
}
