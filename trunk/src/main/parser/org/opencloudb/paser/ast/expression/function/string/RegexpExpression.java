/*
 * Copyright 2012-2015 org.opencloudb.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * (created at 2011-1-19)
 */
package org.opencloudb.paser.ast.expression.function.string;

import org.opencloudb.paser.ast.expression.BinaryOperatorExpression;
import org.opencloudb.paser.ast.expression.Expression;
import org.opencloudb.paser.visitor.SQLASTVisitor;

/**
 * <code>higherPreExpr 'NOT'? ('REGEXP'|'RLIKE') higherPreExp</code>
 * 
 * @author mycat
 */
public class RegexpExpression extends BinaryOperatorExpression {
    private final boolean not;

    public RegexpExpression(boolean not, Expression comparee, Expression pattern) {
        super(comparee, pattern, PRECEDENCE_COMPARISION);
        this.not = not;
    }

    public boolean isNot() {
        return not;
    }

    @Override
    public String getOperator() {
        return not ? "NOT REGEXP" : "REGEXP";
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}