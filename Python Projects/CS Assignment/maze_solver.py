""" For this code to work the "maze_helper" file should also be used """

import maze_helper


def dfs(maze, position, explored=[]):
    explored.append(position)
    dfs_maze = maze_helper.sample_maze()
    adjacent = maze_helper.get_adjacent_positions(dfs_maze, position)
    for i in adjacent:
        if i not in explored:
            dfs(maze, i)

    for i in explored[1:]:
        if maze_helper.symbol_at(maze, i) != "X":
            maze_helper.add_walk_symbol(maze, i)
        else:
            maze_helper.add_walk_symbol(maze, i)
            maze_helper.print_maze(maze)
    return "\nSuccess"


def main():
    position = (5, 0)
    maze = maze_helper.sample_maze()
    test = dfs(maze, position)
    print(test)


if __name__ == "__main__":
    main()
