import React from 'react';
import Button from 'react-toolbox/lib/button/Button';
import Input from 'react-toolbox/lib/input/Input';

class LoanCreateCard extends React.Component {

  render() {
    return (
      <section>
        <header>
            <h3>Lend Loan</h3>
        </header>
        <section className="section-content">
            <h5>Loan Details</h5>
            <div className="row">
                <div className="col-lg-4 col-sm-12 col-md-6">
                    <Input type='text' label='Borrower' />
                </div>
                <div className="col-lg-4 col-sm-12 col-md-6">
                    <Input type='text' label='Guranteer' />
                </div>
                <div className="col-lg-4 col-sm-12 col-md-6">
                    <Input type='text' label='Remarks' />
                </div>
                <div className="col-lg-3 col-sm-12 col-md-6">
                    <Input type='text' label='Principle' />
                </div>
                <div className="col-lg-3 col-sm-12 col-md-6">
                    <Input type='text' label='Rate' />
                </div>
                <div className="col-lg-3 col-sm-12 col-md-6">
                    <Input type='text' label='Collection Frequency' />
                </div>
                <div className="col-lg-3 col-sm-12 col-md-6">
                    <Input type='text' label='Tenure' />
                </div>
            </div>
        </section>
      </section>
    );
  }
}

export default LoanCreateCard;