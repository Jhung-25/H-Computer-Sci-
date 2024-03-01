import re
import os
import networkx as nx

data = []
with open('agentData.csv','r') as file: 
    for line in file:
        data.append(line.strip().split(','))

def to_record(line):
    return [line[0]] + list(map(int, line[1:]))

data_records = [to_record(row) for row in data[1:]]
def create_agent_id_map(data):
    return {row[0]:index for index, row in enumerate(data)}


def create_group_id_map(header_row):
    return{name: index for index, name in enumerate(header_row)}

def get_column(matrix, col):
    return [row[col] for row in matrix]

agent_id_map = create_agent_id_map(data)
group_id_map = create_group_id_map(data[0])
def transpose(matrix):
    return list(map(list, zip(*matrix)))
def innerProduct(a,b):
    return sum(x*y for x,y in zip(a,b))
def matrixMultiply(A,B):
    B_transposed = transpose(B)
    return [[innerProduct(a_row, b_row) for b_row in B_transposed] for a_row in A]