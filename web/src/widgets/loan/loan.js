import React from 'react';
import Button from 'react-toolbox/lib/button/Button';
import LoanCreateCard from '../../components/loanCreateCard';

class Loan extends React.Component {

  state = {
    mode: 'init'
  };
  getCurrentModeLoanCard = () => {
    if(this.state.mode === 'create') {
      return <LoanCreateCard />;
    }
    else {
      return null;
    }
  };

  changeMode = (mode) => {
    this.setState({
        mode: mode
    });
  };

  render() {
    return (
      <div className="row">
        <div className="col-lg-12 col-sm-12 col-md-12">
          <Button className="button-spacing" label='Lend New Loan' onClick={this.changeMode.bind(this, 'create')}
            raised/>
          <Button className="button-spacing" label='Approve Loan' raised primary/>
        </div>
        <div className="col-lg-12 col-sm-12 col-md-12">
          {this.getCurrentModeLoanCard()}
        </div>
      </div>
    );
  }
}

export default Loan;