//Objective is the same as 'N Queens', except this time we want to find 
//the NUMBER of valid boards

let n = 6


//O(n!) solution where n is the input value
//We use backtracking and hashsets to keep track of the valid boards

let result = []
let newArr = new Array(n).fill(0).map(() => new Array(n).fill(0))

let diagonal = new Set()
let diagonal2 = new Set()
let vertical = new Set()

function placeQueen(board, i, diagonal, diagonal2, vertical) {
    //If we reach the end of the board, create the board of '.' and 'Q'
    if (i == board.length) {
        addToList(board)
        return
    }
    
    for (let j = 0; j < board[0].length; j++) {
        if (!diagonal.has(i + j) && !diagonal2.has(j - i) && !vertical.has(j)) {
            board[i][j] = 1
            diagonal.add(i + j)
            diagonal2.add(j - i)
            vertical.add(j)
            
            placeQueen(board, i + 1, diagonal, diagonal2, vertical)
            
            board[i][j] = 0
            diagonal.delete(i + j)
            diagonal2.delete(j - i)
            vertical.delete(j)
        }
    }
}

function addToList(board) {
    let solution = []
    
    for (let i = 0; i < board.length; i++) {

        //Make a separate string for each row
        let string = ''
        for (let j = 0; j < board[i].length; j++) {
            if (board[i][j] == 0) {
                string += '.'
            } else {
                string += 'Q'
            }
        }
        solution.push(string)
    }
    
    result.push(solution)
}

placeQueen(newArr, 0, diagonal, diagonal2, vertical)
return result.length