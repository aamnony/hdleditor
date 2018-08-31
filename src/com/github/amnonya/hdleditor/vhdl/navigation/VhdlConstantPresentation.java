package com.github.amnonya.hdleditor.vhdl.navigation;

import com.github.amnonya.hdleditor.utils.StringUtils;
import com.github.amnonya.hdleditor.vhdl.VhdlIcons;
import com.github.amnonya.hdleditor.vhdl.psi.VhdlConstantDeclaration;
import com.github.amnonya.hdleditor.vhdl.psi.VhdlExpression;
import com.intellij.navigation.ItemPresentation;

import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

public class VhdlConstantPresentation implements ItemPresentation {
    private final VhdlConstantDeclaration declaration;
    private final int index;

    public VhdlConstantPresentation(VhdlConstantDeclaration declaration, int index) {
        this.declaration = declaration;
        this.index = index;
    }

    @Override
    public String getPresentableText() {
        String name = declaration.getIdentifierList().getIdentifierList().get(index).getName();
        String type = StringUtils.shrinkParenthesis(declaration.getSubtypeIndication().getText());
        VhdlExpression expression = declaration.getExpression();

        if (expression == null) {
            return String.format("%s: %s", name, type);
        } else {
            return String.format("%s: %s = %s", name, type, expression.getText());
        }
    }

    @Nullable
    @Override
    public String getLocationString() {
        return null;
    }

    @Override
    public Icon getIcon(boolean unused) {
        return VhdlIcons.CONSTANT;
    }
}
