import React from 'react';
import _ from 'lodash';
import './table.css';

class HeaderCell extends React.Component {
    render() {
        return (<th>
            {this.props.header.label}
        </th>);
    }
}
class HeaderRow extends React.Component {
    render() {
        return (<tr>
            {this.props.headers.map(function (header, index) {
                return (<HeaderCell key={index} header={header} />);
            })}
        </tr>);
    };
}

class BodyCell extends React.Component {
    getCellValue = (value, type)=> {
        if(type === Date && value !== null){
            return (new Date(value)).toLocaleDateString();
        } else {
            return value;
        }
    };
    click = () => {
        this.props.click(this.props.cell);
    };
    render() {
        return (<td onClick={this.click.bind(this)}>
            {this.getCellValue(this.props.cell, this.props.type)}
        </td>);
    }
}
class BodyRow extends React.Component {
    click = (cell) => {
        this.props.click({
            row: this.props.row,
            cell: cell
        });
    };

    render() {
        var row = this.props.row;
        var me = this;
        return (<tr className="hand-pointer" >
            {this.props.headers.map(function (header, index) {
                return (<BodyCell key={index} cell={row[header.key]} type={header.type} click={me.click.bind(me)}/>);
            })}
        </tr>);
    };
}

class TableHead extends React.Component {
    render() {
        return (<thead>
            <HeaderRow headers={this.props.headers} />
        </thead>);
    };
}

class TableBody extends React.Component {
    click = (data) => {
        this.props.click(data);
    };
    render() {
        var headers = this.props.headers;
        var me = this;
        return (<tbody>
            {this.props.data.map(function (row, index) {
                return (<BodyRow key={index} row={row} headers={headers} click={me.click.bind(me)}/>)
            })}
        </tbody>);
    };
}

class Table extends React.Component {
    click = (data) => {
        this.props.click(data);
    };
    
    render() {
        return (<table>
            <TableHead headers={this.props.headers} />
            <TableBody headers={this.props.headers} data={this.props.data} click={this.click.bind(this)}/>
        </table>);
    };
}

export default Table;