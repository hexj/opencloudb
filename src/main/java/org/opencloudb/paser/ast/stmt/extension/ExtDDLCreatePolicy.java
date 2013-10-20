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
 * (created at 2012-8-14)
 */
package org.opencloudb.paser.ast.stmt.extension;

import java.util.ArrayList;
import java.util.List;

import org.opencloudb.paser.ast.expression.Expression;
import org.opencloudb.paser.ast.expression.primary.Identifier;
import org.opencloudb.paser.ast.stmt.ddl.DDLStatement;
import org.opencloudb.paser.util.Pair;
import org.opencloudb.paser.visitor.SQLASTVisitor;

/**
 * @author mycat
 */
public class ExtDDLCreatePolicy implements DDLStatement {
    private final Identifier name;
    private final List<Pair<Integer, Expression>> proportion;

    public ExtDDLCreatePolicy(Identifier name) {
        this.name = name;
        this.proportion = new ArrayList<Pair<Integer, Expression>>(1);
    }

    public Identifier getName() {
        return name;
    }

    public List<Pair<Integer, Expression>> getProportion() {
        return proportion;
    }

    public ExtDDLCreatePolicy addProportion(Integer id, Expression val) {
        proportion.add(new Pair<Integer, Expression>(id, val));
        return this;
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

}